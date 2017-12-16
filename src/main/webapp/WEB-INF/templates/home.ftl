<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<link href="resources/css/home.css" rel="stylesheet" />
<div>
    <p>${user.lastName} ${user.firstName}</p>
    <p>${user.sex}</p>
</div>

<#include "dialogbtn.ftl">
<#include "dialoglistbtn.ftl">

<@sf.form role="form" action='/home/addposttouser${user.id}' method="post" modelAttribute="postForm">
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


<#list posts as post>
    <p>Author: ${post.author.firstName} ${post.author.lastName}</p>
    <a href="/home/${post.id}">
        <p>Text: ${post.text}</p>
    </a>
    <p>Date: ${post.date}</p>
</#list>



<#include "homebtn.ftl">
<#include "allusersbtn.ftl">
