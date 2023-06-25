package io.github.devdevx.mm.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SourceOne {
    private String valueOne;
    private String valueTwo;
    private String valueThree;

    private SubSourceOne subSourceOne;
}
