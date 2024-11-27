/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.project2.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public String getResolutionTip() {
        return "Verify the resource ID or contact support.";
    }

    public String getDeveloperHint() {
        return "Ensure the repository has the correct implementation.";
    }
}
