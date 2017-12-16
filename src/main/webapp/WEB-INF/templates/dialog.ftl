<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>


<#list messages as message>
${message.date} ${message.author.firstName} ${message.author.lastName}: ${message.text}<br>
</#list>

<@sf.form role="form" action='/sendmessageto${recipientId}' method="post" modelAttribute="messageForm">
<fieldset>
    <div class="field">
        <@sf.label path="text">Text</@sf.label>
        <@sf.input path="text" cssClass="form-control" type="text"/>
        <@sf.errors path="text" cssClass="help-block"/>
    </div>
    <div class="form-group">
        <input class="btn btn-info btn-outline" type="submit" value="Send">
    </div>
</fieldset>
</@sf.form>

<#include "homebtn.ftl">
<#include "dialoglistbtn.ftl">