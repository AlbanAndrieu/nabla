# ansible-vagrant

A role for installing conky.


## Actions

- Ensures that conky is installed (using `apt`)


## Usage:
```
  - name: Install conky
    hosts: workstation
    user: root
  #  connection: local
    
    roles:
      - conky      
      
  vars:      
      conky_home: '/workspace/users/albandri10/.conky'      
```

## Sample hosts:
``` 
[workstation]
albandri-laptop-misys

[workstation:vars]
user=albandri
version=10
home=/workspace/users/{{ user }}{{ version }}/
```

## License

MIT
