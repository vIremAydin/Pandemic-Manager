import "./button-style.css"


const MyButton = ({name, isActive, onClick}) =>{

    return(<div>
        {
            isActive ?
                <button className={"notActive"} disabled={true} onClick={() =>onClick(name)}
                       >{name}
                </button>
                :
                <button  className={"Active"} onClick={() =>onClick(name)}
                      >{name}
                </button>
        }
    </div>

    );
}
export default MyButton;
