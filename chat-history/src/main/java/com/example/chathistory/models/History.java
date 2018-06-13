package com.example.chathistory.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "chat_history")

public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usr")
    private String usr;

    @Column(name = "msg")
    private String msg;

    @Column(name = "time")
    private String time;
}