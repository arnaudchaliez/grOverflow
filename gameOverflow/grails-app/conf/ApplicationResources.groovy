modules = {
    application {
        resource url: 'js/application.js'
    }
    bootstrapInput{
        dependsOn 'bootstrap'

        resource url: 'js/bootstrap-tagsinput.js'
        resource url: 'css/bootstrap-tagsinput.css'
    }
    typeahead{
        dependsOn 'jquery, bootstrap'

        resource url: 'js/typeahead.js'
    }
}