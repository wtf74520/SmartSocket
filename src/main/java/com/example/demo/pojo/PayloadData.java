package com.example.demo.pojo;

import lombok.Data;

/**
 * PayloadData class represents the payload data structure for the system.
 * It contains various fields such as state, led, version, debug, info, on, countdown, starttime, endtime, timer, reverse, voltage, current, power, energy, freq, pows, and time.
 *
 * @author Tabnine
 */
@Data

public class PayloadData {
    /**
     * The id of the client
     */
    private int deviceId;
    /**
     * The state of the system.
     */
    private int state;

    /**
     * The LED status.
     */
    private int led;

    /**
     * The version of the system.
     */
    private String version;

    /**
     * The debug mode status.
     */
    private int debug;

    /**
     * The information about the system.
     */
    private String info;

    /**
     * The on status of the system.
     */
    private int on;

    /**
     * The countdown timer for the system.
     */
    private int countdown;

    /**
     * The start time of the system.
     */
    private String starttime;

    /**
     * The end time of the system.
     */
    private String endtime;

    /**
     * The timer for the system.
     */
    private int timer;

    /**
     * The reverse status of the system.
     */
    private int reverse;

    /**
     * The voltage of the system.
     */
    private String voltage;

    /**
     * The current of the system.
     */
    private String current;

    /**
     * The power of the system.
     */
    private String power;

    /**
     * The energy of the system.
     */
    private String energy;

    /**
     * The frequency of the system.
     */
    private String freq;

    /**
     * The power statuses of the system.
     */
    private String pows;

    /**
     * The time of the system.
     */
    private String time;



    // Constructors, getters, setters, and other methods can be added here.
}