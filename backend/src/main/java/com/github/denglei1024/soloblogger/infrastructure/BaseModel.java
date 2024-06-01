package com.github.denglei1024.soloblogger.infrastructure;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * BaseModel
 *
 * @author denglei
 * @since 2024-06-01 22:52
 */
@Data
public abstract class BaseModel implements Serializable {
    private LocalDateTime createdAt;
}