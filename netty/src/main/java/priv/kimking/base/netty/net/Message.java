package priv.kimking.base.netty.net;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * @author kim
 * @date 2020/9/27
 */
@Data
@AllArgsConstructor
public class Message implements Serializable {

    private String content;

}
