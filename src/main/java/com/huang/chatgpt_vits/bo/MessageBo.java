package com.huang.chatgpt_vits.bo;

import com.huang.chatgpt_vits.pojo.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class MessageBo {
    private String role;
    private String content;

    //符合openai的msg
    public List<MessageBo> toMsgList(List<Message> messages) {
        ArrayList<MessageBo> msgs = new ArrayList<>();
        MessageBo msg = null;
        for (int i = 0; i < messages.size(); i++) {
            msg = toMsg(messages.get(i));
            msgs.add(msg);
        }
        return msgs;
    }

    //message转msg
    public MessageBo toMsg(Message message) {
        MessageBo msg = new MessageBo(message.getRole(), message.getContent());
        return msg;
    }
}
