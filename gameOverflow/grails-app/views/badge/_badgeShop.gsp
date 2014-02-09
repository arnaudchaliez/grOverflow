    <div id="badge-shop-thumbnail" class="thumbnail">
        <img src="${resource(dir: 'images/badges', file: "${badge.picture}")}" alt="${badge.name}"/>
        <div class="caption">
            <h3>${badge.name}</h3>
            <span class="coins">${badge.price}</span>
            <p>${badge.description}</p>
            <g:form url="[resource: badge, action:'buy']" >
                <fieldset class="buttons">
                    <g:submitButton name="buy" value="${message(code: 'buy.label', default: 'Buy')}" />
                </fieldset>
            </g:form>
        </div>
    </div>