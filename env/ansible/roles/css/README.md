# ansible-css

A role for installing css.


## Actions

- Ensures that css is installed (using `apt`)


## Usage:
```
  - name: Install css
    hosts: css
    user: root
  #  connection: local
    
    roles:
      - css      
```

## License

MIT
