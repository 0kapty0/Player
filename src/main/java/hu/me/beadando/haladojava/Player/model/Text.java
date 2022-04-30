package hu.me.beadando.haladojava.Player.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**  Ez gyakorlatilag a videó felirata vagy a zene szövege lenne
 *   Nem jutott eszembe jobb név, vagy hogy akkor mnost mi is legyen Lyrics vs Subtitle :D */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Text {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String text;
}
