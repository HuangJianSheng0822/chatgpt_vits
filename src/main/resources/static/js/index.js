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
            let r_chat_html = $(
                '<div class="message robot_msg"><p></p></div>'
            );
            if (data.code === 200) {
                r_chat_html.children("p").text(data.data)
            }
            $(".left").append(r_chat_html)
            let message = document.getElementById('u_list');
            message.scrollTop = message.scrollHeight;
        },
        errors: function (XMLHttpRequest, textStatus, errorThrown) {

        }

    })
})


//数据加载
$.ajax({
    type: "get",
    url: "api/speakerId.json",
    contentType: "application/json;chatset=utf-8",
    success: function (data, textStatus) {

        //赋值
        for (let i = 0; i < data.DATA.length; i++) {
            let op_html = $('<option></option>');
            let key = Object.keys(data.DATA[i]);
            let value = Object.values(data.DATA[i]);
            op_html.attr("value", key)
            op_html.text(value)
            $('#speakerId').append(op_html)
        }
    },
    errors: function (XMLHttpRequest, textStatus, errorThrown) {

    }

})


//响应音频点击服务
$(".left").on('click', '#go_vits', function () {
    //获取数据
    let text = $(this).parent('p').text();
    let speakerId = parseInt($('#speakerId').val())
    let length = parseFloat($('#length').val())
    let lang = $('#lang').val()
    $.ajax({
        type: "post",
        url: "/getVits",
        contentType: "application/json;chatset=utf-8",
        data: JSON.stringify({
            text: text,
            speakerId: speakerId,
            lang: lang,
            length: length
        }),
        success: function (data, textStatus) {
            $('#speak').attr('src', data.data)

            console.log(data.data)
        },
        errors: function (XMLHttpRequest, textStatus, errorThrown) {

        }

    })
})
