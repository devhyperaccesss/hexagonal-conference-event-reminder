package fr.kevin.llps.conf.event.reminder.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bbl")
public class BBLEntity {

    public BBLEntity(String title, String description, LocalDateTime date, SpeakerEntity speaker, String company) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.speaker = speaker;
        this.company = company;
    }

    @Id
    @GeneratedValue
    @Column(name = "bbl_id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "title", nullable = false, columnDefinition = "VARCHAR(100)")
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "VARCHAR(1000)")
    private String description;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "speaker_id")
    private SpeakerEntity speaker;

    @Column(name = "company", nullable = false, columnDefinition = "VARCHAR(100)")
    private String company;

}
