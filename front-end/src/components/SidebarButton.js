import "./sidebarButton.css"

const SidebarButton = ({name, onClick}) => {
    return (<div>
        <button className={"sideBtn"} onClick={onClick}
        >{name}
        </button>
    </div>)
}
export default SidebarButton;
