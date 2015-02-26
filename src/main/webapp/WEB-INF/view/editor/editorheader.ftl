<div class="row">
    <div class="blog-header" style="padding-left: 60px;padding-right: 60px;padding-bottom: 10px;">
        <div class="input-group input-group-lg">
            <span class="input-group-addon" id="sizing-addon1">标题</span>
            <input id="blogtitle" type="text" class="form-control" placeholder="在此写标题..." aria-describedby="sizing-addon1">
        </div>
    </div>
</div>
<div class="row" style="padding-right: 60px;padding-left: 60px;">
    <div class="catalog"><!--分类-->
        <#list catalogList as cata>
            <label class="radio-inline">
                <input type="radio" name="cata" id="${cata.catalogId!}" value="${cata.catalogId!}"> ${cata.catalogName!}
            </label>
        </#list>
        <input value="添加" type="button" id="addCata" onclick="addCata(this);">
    </div>
</div>
