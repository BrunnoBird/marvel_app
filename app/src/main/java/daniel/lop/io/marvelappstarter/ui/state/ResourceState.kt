package daniel.lop.io.marvelappstarter.ui.state

//Util para trabalhar com estados de tipod e ERRO e SUCESSO ...
//Abstração -> restringi o uso de herança de outras classes, pode ser instanciada várias vezes e pode armazenar varios estados diferentes em determinadas instancias
sealed class ResourceState<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : ResourceState<T>(data)
    class Error<T>(message: String, data: T? = null) : ResourceState<T>(data, message)
    class Loading<T> : ResourceState<T>()
    class Empty<T> : ResourceState<T>()
}