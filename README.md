# Dictionary App

This repository contains a dictionary app built with clean architecture principles, leveraging Dagger Hilt for dependency injection, RoomDB for local data storage, Jetpack Compose for the UI, and a caching concept to enhance performance.

## Features

- **Clean Architecture:** The app follows the principles of clean architecture, separating concerns into layers: presentation, domain, and data.

- **Dagger Hilt:** Dependency injection is handled with Dagger Hilt, providing a scalable and maintainable way to manage dependencies.

- **RoomDB:** Local data storage is implemented using RoomDB, allowing for efficient caching and retrieval of dictionary data.

- **Jetpack Compose:** The UI is built using Jetpack Compose, offering a modern and declarative approach to UI development.

- **Caching Concept:** The app employs a caching strategy to optimize data retrieval, providing a seamless user experience while minimizing network requests.

## Project Structure

- **app:** Contains the main application code, including the UI implemented with Jetpack Compose.
  
- **domain:** Houses the business logic and use cases, ensuring separation from implementation details.

- **data:** Manages data-related tasks, such as fetching data from remote sources and caching it using RoomDB.

- **di:** Handles dependency injection setup with Dagger Hilt.

## Dependencies

- Dagger Hilt: [link](https://dagger.dev/hilt/)
- RoomDB: [link](https://developer.android.com/training/data-storage/room)
- Jetpack Compose: [link](https://developer.android.com/jetpack/compose)

## Contributing

Contributions are welcome! Feel free to open issues or pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details. DictionaryApp
