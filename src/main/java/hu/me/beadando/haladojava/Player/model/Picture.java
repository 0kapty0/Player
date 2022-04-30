package hu.me.beadando.haladojava.Player.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**  Kép
 *   amely használható a zenéknél borítóképnek, vagy a videónál előnézeti kisképnek */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Picture {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String pictureURL;
}
