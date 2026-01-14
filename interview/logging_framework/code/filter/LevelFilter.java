package interview.logging_framework.code.filter;

import interview.logging_framework.code.core.LogFilter;
import interview.logging_framework.code.core.LogLevel;
import interview.logging_framework.code.core.LogMessage;

/**
 * Filter that only allows messages with level >= configured level.
 */
public class LevelFilter implements LogFilter {
    private LogLevel level;

    public LevelFilter() {
        this(LogLevel.DEBUG); // Default to allow all levels
    }

    public LevelFilter(LogLevel level) {
        this.level = level;
    }

    @Override
    public boolean shouldLog(LogMessage message) {
        return message.getLevel().isGreaterOrEqual(level);
    }

    @Override
    public void setLevel(LogLevel level) {
        this.level = level;
    }

    @Override
    public LogLevel getLevel() {
        return level;
    }
} 
