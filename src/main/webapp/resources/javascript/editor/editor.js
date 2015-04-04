$(document).ready(function(){
    $('#save-editor').click(saveeditor);
    $('input[name=cata]').first().click()
});

var saveeditor = function saveeditor(){
    var title = $('#blogtitle').val();
    var catalog_id = $('input[name=cata]:checked').val();
    var blog_content = $('#editor').html();

    $.ajax({
        type:"POST",
        url:window.location.origin + "/blog/add",
        data:{blogTitle:title,blogContent:blog_content,catalogId:catalog_id},
        success:function(data){
            window.location.href = data;
        }
    });
}

var addCata = function addCata(obj){
    $(obj).attr("type","text");
    $(obj).val("");
    $(obj).attr("id","newCata");
    $(obj).attr("onclick","void();");
    $('div[class=catalog]').append("<input value=\"保存\" type=\"button\" id=\"saveNewCata\">");
    $('#saveNewCata').click(function(){
        if($('#newCata').val() == ""){
            alert("类别名称不能为空");
            return;
        }
        $.ajax({
            type:"POST",
            url:window.location.origin + "/cata/save",
            data:{name:$('#newCata').val()},
            success:function(data){
               window.location.href = data;
            }
        });
    });
}
