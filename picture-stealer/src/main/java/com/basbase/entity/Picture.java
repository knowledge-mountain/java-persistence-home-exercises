package com.basbase.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
@Entity
@Table(name = "pictures")
@Getter
@Setter
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nasa_id")
    private Long nasaId;
    @Column(name = "img_src")
    private String imgSrc;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate createdAt;
    @ManyToOne
    @JoinColumn(name = "camera_id")
    private Camera camera;
}
