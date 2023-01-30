def nag() {
    echo "hello "
}

def nalluri() {
    def abc = "hello"
    def component= "frontend"
    echo abc
    echo "component name is ${component}"
}

def hema(){
    echo "${x}"
}
def example(){
def list =["father","mother","wife","daughter"]
    for(i in list) {
        println(i)
    }
    def a=5
    def b=10
    if(a == b){
        print "a and b are same values"
    }else{
        print "a and b are not having same value"
    }
}