<div class="col-md-8 blog-main">
    <div class="blog-post">
        <!--<h2 class="blog-post-title">Sample blog post</h2>-->
        <#if detail.blog.createDate??>
            <p class="blog-post-meta">${detail.blog.createDate?datetime} by <a href="#">${detail.user.userName!}</a></p>
        <#else>
            by <a href="#">${detail.user.userName!}</a></p>
        </#if>
        ${detail.blog.blogContent!}
    </div><!-- /.blog-post -->

    <nav>
        <ul class="pager">
            <li><a href="#">上一篇</a></li>
            <li><a href="#">下一篇</a></li>
        </ul>
    </nav>

</div>