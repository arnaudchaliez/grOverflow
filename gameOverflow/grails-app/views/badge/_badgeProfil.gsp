<div id="badge-thumbnail" class="thumbnail">
    <img src="${resource(dir: 'images/badges', file: "${badge.picture}")}" alt="${badge.name}"/>
    <div class="caption">
        <h3>${badge.name}</h3>
        <span class="coins">${badge.price}</span>
        <p>${badge.description}</p>
    </div>
</div>