import "./App.css"
import { BrowserRouter as Router, Switch, Route } from "react-router-dom"
import About from "./Components/about/About"
import CourseHome from "./Components/allcourses/CourseHome"
import Team from "./Components/team/Team"
import Pricing from "./Components/pricing/Pricing"
import Blog from "./Components/blog/Blog"
import Contact from "./Components/contact/Contact"
import Home from "./Components/home/Home"
import Login from "./Components/registration/Login"
import Registration from "./Components/registration/Registration"
import AddCourse from "./Components/allcourses/AddCourse"
import AddSection from "./Components/allcourses/AddSection"
import Header from "./Components/common/header/Header"
import Footer from "./Components/common/footer/Footer"


function App() {
  return (
    <div>
      <Router>
        <Header/>
        <Switch>
          <Route exact path='/' component={Home} />
          <Route exact path='/about' component={About} />
          <Route exact path='/courses' component={CourseHome} />
          <Route exact path='/team' component={Team} />
          <Route exact path='/pricing' component={Pricing} />
          <Route exact path='/journal' component={Blog} />
          <Route exact path='/contact' component={Contact} />
          <Route exact path='/login' component={Login} />
          <Route exact path='/registration' component={Registration} />
          <Route exact path='/addcourse' component={AddCourse} />
          <Route exact path='/addsection' component={AddSection} />
        </Switch>
        <Footer />
      </Router>
    </div>
  )
}

export default App
