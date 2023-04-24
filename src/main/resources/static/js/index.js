//会话id
var diaId = window.localStorage.getItem('diaId')
//发送消息
$("#user_chat").click(function () {
    let role = "user";
    let max_tokens = 100;
    let temperature = 1;
    let top_p = 1;
    let n = 1;
    let content = $("#uesr_content").val();


    let u_chat_html = $('<div class="message user_msg"><p></p></div>')
    u_chat_html.children("p").text(content)
    $(".left").append(u_chat_html)
    let message = document.getElementById('u_list');
    message.scrollTop = message.scrollHeight;


    //判断system是否空
    let dia = JSON.parse(localStorage.getItem(diaId));
    if (dia != null) {
        console.log("dia不空")
        max_tokens = dia.max_tokens;
        temperature = dia.temperature;
        top_p = dia.top_p;
        n = dia.n;
    }
    $.ajax({
        type: "post",
        url: "/sendMsg",
        contentType: "application/json;chatset=utf-8",
        data: JSON.stringify({
            diaId: diaId,
            role: role,
            max_tokens: parseInt(max_tokens),
            temperature: parseFloat(temperature),
            top_p: parseFloat(top_p),
            n: parseFloat(n),
            content: content
        }),
        success: function (data, textStatus) {
            let r_chat_html = $('<div class="message robot_msg"><p><imgsrc="img/icon/Icon_29_Speaker.png" /></p></div>');
            if (data.code === 200) {
                let r_img = '<img src="img/icon/Icon_29_Speaker.png"/>'
                r_chat_html.children("p").text(data.data)
                r_chat_html.children("p").append(r_img)
            }
            $(".left").append(r_chat_html)
            let message = document.getElementById('u_list');
            message.scrollTop = message.scrollHeight;
        },
        errors: function (XMLHttpRequest, textStatus, errorThrown) {

        }

    })
})


$("#btn").click(function () {
    $.ajax({
        type: "post",
        url: "http://localhost:8080/getVits",
        contentType: "application/json;chatset=utf-8",
        data: JSON.stringify({
            text: "好喜欢你",
            speakerId: 133,
            lang: "zh",
            length: 1.4
        }),
        success: function (data, textStatus) {
            console.log("YES")
        },
        errors: function (XMLHttpRequest, textStatus, errorThrown) {

        }

    })
})