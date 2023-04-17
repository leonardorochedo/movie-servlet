import { Row } from "./components/Row/Row"
import { categories } from './api';

import './App.css'

export function App() {

  return (
    <div className="App">
      {categories.map((category) => {
        return (
          <Row
            key={category.name}
            title={category.title}
            path={category.path}
            isLarge={category.isLarge}
          />
        )
      })}
    </div>
  )
}
