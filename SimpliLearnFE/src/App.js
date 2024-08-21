import "./App.css"
import Header from "./Components/common/header/Header"
import { BrowserRouter as Router, Switch, Route } from "react-router-dom"
import About from "./Components/about/About"
import CourseHome from "./Components/allcourses/CourseHome"
import Team from "./Components/team/Team"
import Pricing from "./Components/pricing/Pricing"
import Blog from "./Components/blog/Blog"
import Contact from "./Components/contact/Contact"
import Footer from "./Components/common/footer/Footer"
import Home from "./Components/home/Home"
function App() {
  return (
    <>
      <Router>
        <Header />
        <Switch>
          <Route exact path='/' component={Home} />
          <Route exact path='/about' component={About} />
          <Route exact path='/courses' component={CourseHome} />
          <Route exact path='/team' component={Team} />
          <Route exact path='/pricing' component={Pricing} />
          <Route exact path='/journal' component={Blog} />
          <Route exact path='/contact' component={Contact} />
        </Switch>
        <Footer />
      </Router>
    </>
  )
}

export default App
