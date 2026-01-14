# Logging Framework Design Approach

## Step 1: Clarify Requirements

### Functional Requirements

1. **Log Levels with Priority System**:
    - Support 5 log levels: `DEBUG`, `INFO`, `WARNING`, `ERROR`, `FATAL`.
    - Each level has a priority:
      - `DEBUG=1`, `INFO=2`, `WARNING=3`, `ERROR=4`, `FATAL=5`.
    - Only log messages with priority ≥ configured level.
    - **Example**: If level is set to `WARNING`, only `WARNING`, `ERROR`, and `FATAL` messages are logged.

2. **Log Message Structure**:
    - Each log message contains:
      - `timestamp`: When the log was created.
      - `level`: Severity of the message.
      - `message`: What happened.
      - `source` (optional): Which class/method generated the log.

3. **Multiple Output Destinations**:
    - **Console**: Display logs in terminal/console (for development).
    - **File**: Save logs to a file (for production).
    - **Database**: Store logs in a database (for analysis).
    - The same log message can go to multiple destinations simultaneously.

4. **Configuration System**:
    - Set logging level for the entire application.
    - Choose which output destinations to use.
    - Configure formatting rules.
    - Simple configuration without complex filtering.

5. **Thread Safety**:
    - Multiple threads can log simultaneously without data corruption.
    - No lost or mixed-up log messages.
    - Thread-safe operations for all logging components.

6. **Extensibility**:
    - Easy to add new output destinations (e.g., email, network, cloud storage).
    - Easy to add new log levels if needed.
    - Easy to add custom formatting.

7. **Message Formatting**:
    - Customize how log messages appear in output.
    - Control timestamp format, level display, and message layout.
    - Different formats for different destinations.

> **Interview Tip**: Confirm with the interviewer which destinations, formats, and levels are must-have features before designing the architecture. This ensures your solution meets their expectations while showing your attention to detail.

### Non-Functional Requirements

- **Thread Safety**: Handle concurrent logging without data corruption.
- **Performance**: Minimal overhead for logging operations.
- **Extensibility**: Easy to add new log levels and destinations.
- **Configurability**: Runtime configuration changes.
- **Memory Efficiency**: Reasonable memory usage.

### Edge Cases to Consider

- Multiple threads logging simultaneously (writing in the same lines).
- Invalid log levels or configurations.
- File system full during file logging.
- Database connection failure during database logging.

---

## Step 2: Identify Core Entities

### 1. `LogLevel`
```java
enum LogLevel {
     DEBUG(1), INFO(2), WARNING(3), ERROR(4), FATAL(5);

     private final int priority;

     public boolean isGreaterOrEqual(LogLevel other) {
          return this.priority >= other.priority;
     }
}
```

### 2. `LogMessage`
```java
class LogMessage {
     private final Timestamp timestamp;
     private final LogLevel level;
     private final String message;
     private final String source; // Optional

     // Builder pattern for construction
     public static class Builder {
          // Implementation here
     }
}
```

### 3. `LogConfiguration`
```java
class LogConfiguration {
     private LogLevel rootLevel;

     public void setRootLevel(LogLevel level) {
          this.rootLevel = level;
     }

     public LogLevel getRootLevel() {
          return rootLevel;
     }
}
```

> **Interview Tip**: Use enums for fixed sets like log levels to ensure type safety and make comparisons easier. It also improves code readability.

---

## Step 3: Visualize Interaction Flows

### Basic Logging Flow
1. Application creates a log message.
2. Logger processes the message.
3. If the message passes the level check, the logger sends it to output destinations.
4. Each destination writes the message.

### Configuration Flow (Real-time)
1. Application sets `LogConfiguration`.
2. Logger updates its settings.
3. All future logs follow the new configuration.

### Multi-threaded Flow
1. Multiple threads create log messages simultaneously.
2. Thread-safe logger processes each request.
3. Each destination handles concurrent writes safely.

### Formatting Flow
1. `LogMessage` reaches the destination.
2. Destination formats the message.
3. Formatted message is written to output.

> **Interview Tip**: Visual flow diagrams (sequence diagrams) help interviewers quickly grasp how different components interact. Keep them simple and focused on key steps.

---

## Step 4: Define Class Structures and Relationships

### 1. Core Interfaces

#### `Logger`
```java
interface Logger {
     void debug(String message);
     void info(String message);
     void warning(String message);
     void error(String message);
     void fatal(String message);
     void log(LogLevel level, String message);
     void setLevel(LogLevel level);
     void addAppender(LogAppender appender);
     void addFilter(LogFilter filter);
     void removeFilter(LogFilter filter);
     List<LogAppender> getAppenders();
     List<LogFilter> getFilters();
}
```

#### `LogAppender`
```java
interface LogAppender {
     void append(LogMessage message);
     void setLevel(LogLevel level);
     LogLevel getLevel();
     boolean isEnabled(LogLevel level);
     void setFormatter(LogFormatter formatter);
     LogFormatter getFormatter();
}
```

#### `LogFormatter`
```java
interface LogFormatter {
     String format(LogMessage message);
     void setPattern(String pattern);
     String getPattern();
     void setDateFormat(String dateFormat);
}
```

#### `LogFilter`
```java
interface LogFilter {
     boolean shouldLog(LogMessage message);
     void setLevel(LogLevel level);
     LogLevel getLevel();
}
```

#### `LogConfiguration`
```java
interface LogConfiguration {
     void setRootLevel(LogLevel level);
     LogLevel getRootLevel();
}
```

### 2. Implementation Classes

#### `ConsoleAppender`
- Writes to `System.out`/`System.err` based on level.
- Uses formatter to format messages before output.

#### `FileAppender`
- Writes to a specified file with a timestamp.
- Uses formatter to format messages before writing.

#### `DatabaseAppender`
- Writes to a database table.
- Uses formatter to format messages before storage.

#### `SimpleFormatter`
- Default format: `[LEVEL] TIMESTAMP - MESSAGE`.
- Configurable date format and pattern.

#### `DetailedFormatter`
- Extended format: `[LEVEL] TIMESTAMP [SOURCE] - MESSAGE`.
- Includes source information when available.

#### `LevelFilter`
- Filters messages based on minimum log level.
- Only allows messages with level ≥ configured level.

#### `SourceFilter`
- Filters messages based on source/class name.
- Can include or exclude specific packages/classes.

---

## Step 5: Core Use Cases & Methods

### Basic Logging Use Case
```java
logger.info("message");
// Internally:
LoggerImpl.log(LogLevel.INFO, "message");
LogMessage message = new LogMessage.Builder()
     .level(LogLevel.INFO)
     .message("message")
     .build();
if (message.getLevel().isGreaterOrEqual(logger.getLevel())) {
     for (LogAppender appender : logger.getAppenders()) {
          if (appender.isEnabled(message.getLevel())) {
                appender.append(message);
          }
     }
}
```

### Configuration Use Case
```java
logger.setLevel(LogLevel.WARNING);
// Updates configuration; future logs use the new level.
```

### Multi-threaded Use Case
```java
synchronized (logger) {
     logger.info("Thread-safe message");
}
```

### Filtering Use Case
```java
for (LogFilter filter : logger.getFilters()) {
     if (!filter.shouldLog(message)) {
          return; // Drop message
     }
}
```

### Formatting Use Case
```java
LogFormatter formatter = appender.getFormatter();
String formatted = formatter.format(message);
appender.write(formatted);
```

---

## Step 6: OOP Principles & Design Patterns

### Design Patterns Used
- **Strategy Pattern**: For different appenders and formatters.
- **Chain of Responsibility Pattern**: For filter chain processing.
- **Builder Pattern**: For constructing `LogMessage` objects.

### SOLID Principles
- **Single Responsibility**: Each class has one clear purpose.
- **Open/Closed**: Easy to add new appenders without modifying existing code.
- **Liskov Substitution**: All appenders are interchangeable.
- **Interface Segregation**: Clean interfaces with only required methods.
- **Dependency Inversion**: Depend on interfaces, not specific implementations.

---

## Step 7: Handle Edge Cases

### Edge Case Solutions

1. **Multiple Threads Logging**:
    - Use `synchronized` methods or concurrent collections.
    - Implement thread-safe appender implementations.

2. **Invalid Log Levels**:
    - Validate inputs in the `LogLevel` enum.
    - Default to `ERROR` level for invalid inputs.

3. **File System Full**:
    - Wrap file operations in `try-catch` blocks.
    - Fallback to console logging or an in-memory buffer.

4. **Database Connection Failure**:
    - Use connection pooling and retry logic.
    - Fallback to file or console logging.

5. **Invalid Format Patterns**:
    - Validate format patterns in formatter implementations.
    - Fallback to a safe/simple format when invalid.

6. **Filter Configuration Errors**:
    - Validate filter parameters at registration time.
    - Default to accept-all behavior for invalid filters.

> **Interview Tip**: When explaining edge-case handling, state trade-offs (e.g., fail-open vs fail-closed, sync vs async write) and why you chose a particular fallback.

