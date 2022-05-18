package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoRestComment {
    private int id;
    private int post_id;
    private String name;
    private String email;
    private String body;
}
