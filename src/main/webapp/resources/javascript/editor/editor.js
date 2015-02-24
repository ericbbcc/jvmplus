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
            if(data == "success"){
                alert("保存成功！");
            }else{
                alert(date);
            }
        }
    });
}