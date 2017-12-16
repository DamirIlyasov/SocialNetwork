<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<@sf.form role="form" action='/dialogwith${user.id}' method="get">
<button type="submit">Write message</button>
</@sf.form>