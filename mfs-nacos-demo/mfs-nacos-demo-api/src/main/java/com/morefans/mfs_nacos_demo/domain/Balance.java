package com.morefans.mfs_nacos_demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Balance implements Serializable {

    private int id;
    private int diamond;
    private int ticket;
    private String message;

}