<div class="col-md-8">
    <#list paginationBO.dataList as blog>
        <div class="blog-post">
            <h2 class="blog-post-title">${blog.blogTitle!}</h2>
            <#if blog.createDate??>
                <p class="blog-post-meta">${blog.createDate?datetime} by <a href="#">${user.userName!}</a></p>
            <#else>
                by <a href="#">${user.userName!}</a></p>
            </#if>
            <a href="/blog/view/${blog.blogId!}">查看全文...</a>
        </div><!-- /.blog-post -->
    </#list>
    <#if paginationBO.dataList?size gt 0>
        <nav>
            <ul class="pager">
                <#if paginationBO.page == 0>
                    <li><a href="#" style="color:#CCC">上一页</a></li>
                <#else>
                    <li><a href="/blog/beforeYe/${catalogId!}/${paginationBO.page!}/${paginationBO.pageSize!}">上一页</a></li>
                </#if>
                <#if paginationBO.page == (paginationBO.total - 1)>
                    <li><a href="#" style="color: #CCC">下一页</a></li>
                <#else>
                    <li><a href="/blog/nextYe/${catalogId!}/${paginationBO.page!}/${paginationBO.pageSize!}">下一页</a></li>
                </#if>
            </ul>
        </nav>
    <#else >
    该分类暂无内容
    </#if>
</div>


