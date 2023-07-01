import { categories } from './api';

import { Row } from "./components/Row/Row"
import { Banner } from "./components/Banner/Banner";
import { Nav } from "./components/Nav/Nav";

import './App.css'

export function App() {

  return (
    <div className="App">
      <Nav />
      <Banner />
      {categories.map((category) => {
        return <Row
                  key={category.name}
                  title={category.title}
                  path={category.path}
                  isLarge={category.isLarge}
                />
      })}
    </div>
  )
}
