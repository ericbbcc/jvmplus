<script src="https://mindmup.s3.amazonaws.com/lib/jquery.hotkeys.js"></script>
<script src="/resources/javascript/bootstrap-wysiwyg.js"></script>
<link href="/resources/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
<link href="/resources/css/font-awesome.css" rel="stylesheet">
<div class="container">
<#include "editor/editorheader.ftl" />
    <div class="row">
    <#include "editor/editormain.ftl" />
    </div>
</div>
<script>
    $(document).ready(function(){
        $('#editor').wysiwyg();
    });
</script>

