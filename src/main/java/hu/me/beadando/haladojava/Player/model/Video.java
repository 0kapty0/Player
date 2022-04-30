package hu.me.beadando.haladojava.Player.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**  Videó */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Video {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String artist;
    @NotNull
    @Min(0)
    private int length;
    @NotBlank
    private String genre;
    @NotNull
    private int pictureID;
    @NotNull
    private int textID;
    @NotBlank
    private String status;
}
