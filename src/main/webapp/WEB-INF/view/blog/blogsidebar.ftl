<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
    <div class="sidebar-module sidebar-module-inset">
        <h4>简介</h4>
        <p>JVMPlus是一个以介绍JVM平台技术为主的博客，
            作者：陆晨
        </p>
    </div>
    <div class="sidebar-module">
        <h4>分类</h4>
        <ol class="list-unstyled">
            <#list detail.catalogList as cata>
                <li><a href="#">${cata.catalogName!}</a></li>
            </#list>
        </ol>
    </div>
    <div class="sidebar-module">
        <h4>友情链接</h4>
        <ol class="list-unstyled">
            <li><a href="http://lova.sinaapp.com/">撸哇博客</a></li>
        </ol>
    </div>
</div>