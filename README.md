# LogoQuiz

The project follows MVVM architecture. It contains following :

### MainActivity -> To display logo , empty text views and jumbled suggested letters (incomplete)
### LogoRepository -> It is interface and can be extended to load data from remote or local dataSource
### LogoRepositoryImpl -> Implmenting LogoRepository, it loads data from Json as required.
### LogoViewModel -> It acts as mediator between UI Layer and repository. It also contains logic to check whether logo name is correct or not.
It emits UI states to UI Layer.
