let dialog_outter = document.querySelector(".dialog_outter")
let overlap = document.querySelector(".overlap")
const dialog_html_str = '<div class="dialog_wrapper">' +
    '<div class="dialog_close_btn" onclick="closeDialog()">X</div>' +
    '<div class="dialog_content">' +
    '<div class="form_item">' +
    '<span>标题：</span>' +
    '<input type="text" name="title" placeholder="请输入会话名称" id="title">' +
    '</div>' +
    '<div class="form_item">' +
    '<span>描述：</span>' +
    '<input type="text" name="desc" id="desc">' +
    '</div>' +
    '</div>' +
    '<div class="dialog_btn_group">' +
    '<div class="btn_confirm" onclick="addDia()">确定</div>' +
    '<div class="btn_cancel" onclick="closeDialog()">取消</div>' +
    '</div>' +
    '</div>'

function handleClick() {
    overlap.style.display = "block";
    let fg = document.createRange().createContextualFragment(dialog_html_str)
    dialog_outter.appendChild(fg)
}

function closeDialog() {
    overlap.style.display = "none";
    $('.dialog_wrapper').remove()
}

//添加
function addDia() {
    var title = $("#title").val();
    var desc = $("#desc").val()

    $.ajax({
        type: "post",
        url: "/dia/add",
        data: {
            title: title,
            desc: desc
        },
        success: function (data, textStatus) {
            //追加，页面不刷新
            let str_html = $('<div class="list_item"><input type="text" hidden/><h3></h3><p></p></div><hr>');
            $(str_html).children('input').attr('value', data.data);
            $(str_html).children('h3').text(title);
            $(str_html).children('p').text(desc);
            $(".msg_list").append(str_html);
            closeDialog()
            console.log("YES")
        },
        errors: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log("NO")
        }
    })
}

$(".msg_list").on('click', '.list_item', function () {
    let diaId = $(this).children('input').val()
    let title = $(this).children('h3').text()
    localStorage.setItem('diaId', diaId);
    localStorage.setItem('title', title);
    window.location.href = "index.html"
})


//查询
$.ajax({
    type: "post",
    url: "/dia/getAll",
    success: function (data, textStatus) {
        for (let i = 0; i < data.data.length; i++) {
            let str_html = $('<div class="list_item"><input type="text" hidden/><h3></h3><p></p></div><hr>');
            $(str_html).children('input').attr('value', data.data[i].diaId);
            $(str_html).children('h3').text(data.data[i].title);
            $(str_html).children('p').text(data.data[i].desc);
            $(".msg_list").append(str_html);
        }
        closeDialog();
        console.log("YES")
    },
    errors: function (XMLHttpRequest, textStatus, errorThrown) {
        console.log("NO")
    }
})