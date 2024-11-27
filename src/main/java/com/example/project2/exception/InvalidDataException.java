/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.project2.exception;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }

    public String getDebugTip() {
        return "Check the incoming data payload.";
    }

    public String getUserFriendlyMessage() {
        return "Invalid data provided.";
    }
}
