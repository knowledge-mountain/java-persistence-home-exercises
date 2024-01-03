package com.basbase.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
@Entity
@Table(name = "cameras")
@Getter
@Setter
public class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nasa_id")
    private Long nasaId;
    @Column(name = "name")
    private String name;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camera")
    private List<Picture> pictures = new ArrayList<>();
}
