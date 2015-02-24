<div class="container" >
    <#include "blog/blogheader.ftl" />
    <div class="row">
        <#if listcatalog??>
            <#include "blog/listcatalogmain.ftl" />
        <#else>
            <#include "blog/blogmain.ftl" />
        </#if>
        <#include "blog/blogsidebar.ftl" />
    </div>
</div>

