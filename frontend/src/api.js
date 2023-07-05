const API_DNS = "http://localhost:8080/medias"
const userId = 1

export const categories = [
    {
        name: "trending",
        title: "Em Alta",
        path: "/trending?id=" + userId,
        isLarge: true
    },
    {
        name: "netflixOriginals",
        title: "Originais Netflix",
        path: "/netflixoriginals?id=" + userId,
        isLarge: false
    },
    {
        name: "topRated",
        title: "Populares",
        path: "/toprated?id=" + userId,
        isLarge: false
    },
    {
        name: "comedy",
        title: "Comédias",
        path: "/comedy?id=" + userId,
        isLarge: false
    },  
    {
        name: "romances",
        title: "Romances",
        path: "/romance?id=" + userId,
        isLarge: false
    },
    {
        name: "documentaries",
        title: "Documentários",
        path: "/documentary?id=" + userId,
        isLarge: false
    }
]

export const getMovies = async (path) => {

    try {
        let url = API_DNS + path
        const response = fetch(url)

        return (await response).json()
    } catch (error) {
        console.log("error getMovies: ", error)
    }

    return url; 
}