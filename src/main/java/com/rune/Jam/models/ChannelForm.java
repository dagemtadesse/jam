package com.rune.Jam.models;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class ChannelForm {
    private long id = -1L;
    @Size(min = 4, message = "channel name should be at least 4 characters long ")
    private String name;
    @Size(min = 10, message = "channel description should be at least 4 characters long ")
    private String description;
    @Email
    private String email;
    @Size(min = 4, message = "address should be at least 4 characters long ")
    private String address;

    public Channel toChannel(){
        return new Channel(
                this.getName(),
                "",
                this.getDescription(),
                this.getAddress(),
                this.getEmail(),
                false
        );
    }
}
