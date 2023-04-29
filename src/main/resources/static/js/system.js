var diaId = window.localStorage.getItem('diaId')
//参数存储到本地
let max_tokens = $("#max_tokens").val();
let temperature = $("#temperature").val();
let top_p = $("#top_p").val();
let n = $("#n").val();

//消息发送
$("#sys_chat").click(function () {
	let role = "system";
	let max_tokens = $("#max_tokens").val();
	let temperature = $("#temperature").val();
	let top_p = $("#top_p").val();
	let n = $("#n").val();
	let content = $("#sys_content").val();
	$("#sys_content").val(null)
	let u_chat_html = $('<div class="message user_msg"><p></p></div>')
	u_chat_html.children("p").text(content)
	$(".left").append(u_chat_html)
	let message = document.getElementById('sys_list');
	message.scrollTop = message.scrollHeight;
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
			let dia = {
				diaId: diaId,
				max_tokens: parseInt(max_tokens),
				temperature: parseFloat(temperature),
				top_p: parseFloat(top_p),
				n: parseFloat(n)
			}
			window.localStorage.setItem(diaId, JSON.stringify(dia));
			let r_chat_html = $(
				'<div class="message robot_msg"><p></p></div>'
			);
			if (data.code === 200) {
				r_chat_html.children("p").text(data.data)

			}
			$(".left").append(r_chat_html)
			let message = document.getElementById('sys_list');
			message.scrollTop = message.scrollHeight;
		},
		errors: function (XMLHttpRequest, textStatus, errorThrown) {

		}

	})
})
