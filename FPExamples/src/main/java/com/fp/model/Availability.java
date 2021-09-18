package com.fp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/09/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Availability {

    private Date availabilityDate;

    @Override
    public String toString() {
        return "Availability{" +
                "availabilityDate=" + availabilityDate +
                '}';
    }
}
