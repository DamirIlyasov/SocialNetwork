<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
${post.author.firstName} ${post.author.lastName}
${post.text}
${post.date}

<@sf.form role="form" action='/home/${post.id}' method="post" modelAttribute="commentForm">
<fieldset>
    <div class="field">
        <@sf.label path="text">Text</@sf.label>
        <@sf.input path="text" cssClass="form-control" type="text"/>
        <@sf.errors path="text" cssClass="help-block"/>
    </div>
    <div class="form-group">
        <input class="btn btn-info btn-outline" type="submit" value="Write">
    </div>
</fieldset>
</@sf.form>
<#list comments as comment>
${comment.author.firstName} ${comment.author.lastName} <br>
${comment.text} <br>
${comment.date} <br>
</#list>

<#include "homebtn.ftl">