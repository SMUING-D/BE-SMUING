package dev.umc.smuing.resume;

import dev.umc.smuing.career.Career;
import dev.umc.smuing.matching.Matching;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String motive;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "resume")
    private Matching matching;

    @OneToMany(mappedBy = "resume")
    private List<Career> careers = new ArrayList<>();
}
