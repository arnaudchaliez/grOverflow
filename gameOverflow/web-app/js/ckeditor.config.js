CKEDITOR.editorConfig = function( config ) {
    config.language = 'fr';
    //config.uiColor = '#aaaaaa';
    config.toolbar = [
        [ 'Source', '-', 'Bold', 'Italic', 'Preview', 'Link', 'InsertPre', 'Image', 'NumberedList', 'BulletedList', '-', 'Undo', 'Redo' ]
    ];
    config.forcePasteAsPlainText = true;
    config.removeFormatTags = 'b,big,code,del,dfn,em,i,ins,kbd,ul,ol,li';
};